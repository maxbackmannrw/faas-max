 package com.faas.core.api.model.ws.client.inquiry.dto;

 import com.faas.core.base.model.db.client.content.ClientDBModel;
 import com.faas.core.base.model.db.client.inquiry.ClientInquiryDBModel;
 import com.faas.core.base.model.db.client.session.SessionDBModel;

 public class ApiClientInquiryContent {

    private ClientDBModel client;
    private SessionDBModel clientSession;
    private ClientInquiryDBModel clientInquiry;

     public ApiClientInquiryContent() {
     }

     public ApiClientInquiryContent(ClientDBModel client, SessionDBModel clientSession, ClientInquiryDBModel clientInquiry) {
         this.client = client;
         this.clientSession = clientSession;
         this.clientInquiry = clientInquiry;
     }

     public ClientDBModel getClient() {
         return client;
     }

     public void setClient(ClientDBModel client) {
         this.client = client;
     }

     public SessionDBModel getClientSession() {
         return clientSession;
     }

     public void setClientSession(SessionDBModel clientSession) {
         this.clientSession = clientSession;
     }

     public ClientInquiryDBModel getClientInquiry() {
         return clientInquiry;
     }

     public void setClientInquiry(ClientInquiryDBModel clientInquiry) {
         this.clientInquiry = clientInquiry;
     }
 }
