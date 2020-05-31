package com.example.demo.sns.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SNSMessage {
	private String Type;
	private String MessageId;
	private String TopicArn;
	private String Message;

}
