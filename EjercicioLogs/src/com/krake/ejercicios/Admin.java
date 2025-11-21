package com.krake.ejercicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin {
	private static Logger logger=LogManager.getLogger(Admin.class);

	public void agregar() {
		
		logger.warn("MENSAJE DE warn");
		logger.info("MENSAJE DE INFO");
		logger.debug("MENSAJE DE debug");
		logger.trace("MENSAJE DE trace");
		

		logger.error("MENSAJE DE error");
		
	}

}
