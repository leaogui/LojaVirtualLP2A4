package repo;

import java.util.HashSet;
import java.util.Set;

import entidades.Admin;

public class AdminRepo {
	
	private static Set<Admin> admins = new HashSet<Admin>();
	
	
	
	public static Set<Admin> getAdmins() {
		return admins;
	}
	
	
	
	public static void addAdmin(Admin admin) {
		admins.add(admin);
	}
	
	
	
	
	public static Admin getAdm(String login) {
		
		for (Admin admin : admins) {
			
			if (admin.getCpf().equals(login)) {
				
				return admin;
				
			}
		}
		return null;
	}
	
	
	
	
	public static Admin getAdmLogin(String cpf, String senha) {
		
		for (Admin admin : admins) {
			
			if (admin.getCpf().equals(cpf) && admin.getSenha().equals(senha)) {
				
				return admin;
				
			}
		}
		return null;
	}
	
	
}