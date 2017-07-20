package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MailData implements Serializable {
	
				private String contact_date;
				private String username;
				private String adminname;
				private int mail_id;
				private String subject;
				private String content;
				
				public String getContact_date() {
					return contact_date;
				}
				public void setContact_date(String contact_date) {
					this.contact_date = contact_date;
				}
				public String getUsername() {
					return username;
				}
				public void setUsername(String username) {
					this.username = username;
				}
				public String getAdminname() {
					return adminname;
				}
				public void setAdminname(String adminname) {
					this.adminname = adminname;
				}
				public int getMail_id() {
					return mail_id;
				}
				public void setMail_id(int mail_id) {
					this.mail_id = mail_id;
				}
				public String getSubject() {
					return subject;
				}
				public void setSubject(String subject) {
					this.subject = subject;
				}
				public String getContent() {
					return content;
				}
				public void setContent(String content) {
					this.content = content;
				}
				

}