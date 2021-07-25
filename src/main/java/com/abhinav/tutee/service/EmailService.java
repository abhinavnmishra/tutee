package com.abhinav.tutee.service;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public Boolean invite(String to, String company, String fname, Date date) throws MessagingException, EmailException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String subject = company + ": Invitation to Interview";
        String body = "Dear " + fname + ",\n" +
                "\n<br>" +
                "Thank you for your application at " + company + ". \n" +
                "\n<br>" +
                "We would like to invite you to interview for the role with our Technical Recruiter John. The interview will last 2 hours in total.\n" +
                "\n<br>" +
                simpleDateFormat.format(date) + "\n" +
                "\n<br>" +
                "We look forward to speaking with you. \n" +
                "\n<br>" +
                "Sincerely,\n" +
                "\n<br>" +
                "Placement Office\n" +
                "\n<br>" +
                "Dayananda Sagar College of Engineering";
        return sendEmail(to, subject, body);
    }

    public Boolean success(String to, String company, String fname) throws MessagingException, EmailException{
        String subject = "Your interview with " + company;
        String body = "Dear " + fname + ",\n" +
                "\n<br>" +
                "Thank you for taking the time to interview with " + company + ". We enjoyed getting to know you. We have completed all of our interviews.\n" +
                "\n<br>" +
                "We are pleased to inform you that we would like to offer you the Software Developer position. We believe your past experience and strong Skills will be an asset to our company. Your anticipated starting date is 1st August 2021.\n" +
                "\n<br>" +
                "The next steps in the process will be shared with you soon.\n" +
                "\n<br>" +
                "We look forward to hearing from you.\n" +
                "\n<br>" +
                "Sincerely,\n" +
                "\n<br>" +
                "Naveen Bansal\n" +
                "\n<br>" +
                "Technical Recruiter\n" +
                company + "";
        return sendEmail(to, subject, body);
    }

    public Boolean sendEmail(String to, String subject, String body) throws MessagingException, EmailException {
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);
        mailSender.send(msg);
        return Boolean.TRUE;
    }

}
