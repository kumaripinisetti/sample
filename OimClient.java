package com.ojas;

import java.util.Hashtable;

import javax.security.auth.login.LoginException;

import oracle.iam.platform.OIMClient;

public class OimClient {
	
	static OIMClient client;
	private static String OIMUserName = "xelsysadm";
	private static String OIMPassword = "Ojas1525";
	private static String OIMURL = "t3://TRAINING00003:14000";
	private static String OIMInitialContextFactory = "weblogic.jndi.WLInitialContextFactory";
	
	public static OIMClient loginWithCustomEnv(){
		Hashtable env = new Hashtable();
		env.put(client.JAVA_NAMING_FACTORY_INITIAL,OIMInitialContextFactory);
		env.put(client.JAVA_NAMING_PROVIDER_URL,OIMURL);
		System.setProperty("OIMAppServerType","wls");
		System.setProperty("APPSERVER_TYPE","wls");
		System.setProperty("java.security.auth.login.config","C:\\Oracle\\Middleware\\Oracle_IDM\\server\\config\\authwl.conf");
		client = null;
		System.out.println("client");
		try {
			client = new OIMClient(env);
				System.out.println("Initiating Oim Client");
				client.login(OIMUserName, OIMPassword.toCharArray());
				System.out.println("got OIM client successfully");
				System.out.println("Client - "+client);
			} catch (LoginException e) {
			System.out.println("Error : "+e);
		}
		return client;	
	}
	
	public static void main(String[] args) {
		OimClient.loginWithCustomEnv();
	}
	
	
}
