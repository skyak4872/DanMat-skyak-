package com.cross.Danmat.User.Command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserCommand {
	private String userid;
	private String passwd;
	private String email;
	
	public UserCommand() {
		super();
	}
}
