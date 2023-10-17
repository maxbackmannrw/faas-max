 package com.faas.core.api.model.ws.inquiry.content.dto;

 import com.faas.core.base.model.db.client.content.ClientDBModel;
 import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;
 import com.faas.core.base.model.db.client.session.SessionDBModel;

 public class ApiClientInquiryContent {

    private ClientDBModel client;
    private SessionDBModel clientSession;
    private OperationInquiryDBModel clientInquiry;

     public ApiClientInquiryContent() {
     }

     public ApiClientInquiryContent(ClientDBModel client, SessionDBModel clientSession, OperationInquiryDBModel clientInquiry) {
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

     public OperationInquiryDBModel getClientInquiry() {
         return clientInquiry;
     }

     public void setClientInquiry(OperationInquiryDBModel clientInquiry) {
         this.clientInquiry = clientInquiry;
     }
 }
