package sk.akr.fiit.aass.interceptor;

import jakarta.annotation.Resource;
import jakarta.ejb.EJBContext;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
