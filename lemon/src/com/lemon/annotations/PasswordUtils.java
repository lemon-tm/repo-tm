package com.lemon.annotations;

import java.util.List;

public class PasswordUtils {

	@UseCase(id=47, description="Passwords must contain at least one numeric")
	public boolean validatePawwword(String password){
		return (password.matches("\\w*\\d\\w*")) ;
	}
	
	@UseCase(id=48)
	public String encryptPawwword(String password){
		return new StringBuilder(password).reverse().toString() ;
	}
	
	@UseCase(id=49, description="New passwords can't equal previously used ones")
	public boolean checkForNewPawwword(List<String> prevPasswords, String password){
		return !prevPasswords.contains(password);
	}
	
}
