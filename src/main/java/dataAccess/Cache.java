package dataAccess;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import models.Address;
import models.Certificate;
import models.Employee;
import models.Faq;

//Source: https://www.tutorialspoint.com/guava/guava_caching_utilities.htm
public class Cache {
	public static LoadingCache<Integer, Address> addressCache = CacheBuilder.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES)
			.build(new CacheLoader<Integer, Address>() {
				@Override
				public Address load(Integer key) throws Exception {
					return AddressAccess.get(key);
				}	
			});
	public static LoadingCache<Integer, Employee> employeeCache = CacheBuilder.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES)
			.build(new CacheLoader<Integer, Employee>() {

				@Override
				public Employee load(Integer key) throws Exception {
					return EmployeeAccess.get(key);
				}
			});
	public static LoadingCache<Integer, Certificate> certificateCache = CacheBuilder.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES)
			.build(new CacheLoader<Integer, Certificate>() {

				@Override
				public Certificate load(Integer key) throws Exception {
					return CertificateAccess.get(key);
				}
			});	
	public static LoadingCache<Integer, Faq> faqCache = CacheBuilder.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES)
			.build(new CacheLoader<Integer, Faq>() {

				@Override
				public Faq load(Integer key) throws Exception {
					return FaqAccess.get(key);
				}
			});
	
	public static void loadAllAddresses() throws IOException, URISyntaxException {		
			addressCache.putAll(AddressAccess.getAll());		
	}
	
	public static void loadAllEmployees() throws IOException, URISyntaxException {
		employeeCache.putAll(EmployeeAccess.getAllEmployees());
	}
	
	public static void loadAllCertificates() throws IOException, URISyntaxException {
		certificateCache.putAll(CertificateAccess.getAll());
	}
	
	public static void loadAllFaqs() throws IOException, URISyntaxException {
		faqCache.putAll(FaqAccess.getAll());
	}
}
