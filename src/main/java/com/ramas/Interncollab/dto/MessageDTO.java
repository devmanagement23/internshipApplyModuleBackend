package com.ramas.Interncollab.dto;

public class MessageDTO {

	
	 private Long applicationId;
	    private Long senderId;
	    private String content;
	    
	    //setter and getter
	    
		public Long getApplicationId() {
			return applicationId;
		}
		public void setApplicationId(Long applicationId) {
			this.applicationId = applicationId;
		}
		public Long getSenderId() {
			return senderId;
		}
		public void setSenderId(Long senderId) {
			this.senderId = senderId;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
}
