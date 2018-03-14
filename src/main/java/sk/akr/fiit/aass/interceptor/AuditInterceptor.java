package sk.akr.fiit.aass.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AuditInterceptor {

	@Resource
	private EJBContext ejbContext;

	// metoda bude zavolana "okolo" kazdej metody, na ktoru je interceptor aplikovany
	@AroundInvoke
	public Object zaznamenajVolanieMetody(InvocationContext ctx) throws Exception {
		log.trace("Start metody {} pouzivatelom {}", ctx.getMethod().getName(), ejbContext.getCallerPrincipal().getName());
		try {
			// zavolanie cielovej metody
			return ctx.proceed();
		} finally {
			log.trace("Koniec metody {}", ctx.getMethod().getName());
		}
	}

	private static final Logger log = LogManager.getLogger();
}
