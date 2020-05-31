package com.example.demo.sns.pojo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class MessageWrapper {
	
	private String Type;

    private String MessageId;

    private String TopicArn;

    @JsonDeserialize( using = NotificationDeserializer.class)
    private Producto Message;

    private String Timestamp;

    private String SignatureVersion;

    private String Signature;

    private String SigningCertURL;

    private String UnsubscribeURL;

    private MessageAttributes MessageAttributes;

}
