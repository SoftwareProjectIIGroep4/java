package dataAccess;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import models.Address;
import models.Employee;
import models.Book;

//Source: https://www.tutorialspoint.com/guava/guava_caching_utilities.htm
public class Cache {
	public static LoadingCache<Integer, Address> addressCache = CacheBuilder.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES)
			.build(new CacheLoader<Integer, Address>() {
				@Override
				public Address load(Integer key) throws Exception {
					return AddressAccess.getAddress(key);
				}	
			});
	public static LoadingCache<Integer, Employee> employeeCache = CacheBuilder.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES)
			.build(new CacheLoader<Integer, Employee>() {

				@Override
				public Employee load(Integer key) throws Exception {
					return EmployeeAccess.getEmployee(key);
				}
			});
	
	public static LoadingCache<Long, Book> bookCache = CacheBuilder.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES)
			.build(new CacheLoader<Long, Book>() {

				@Override
				public Book load(Long key) throws Exception {
				return BookAccess.getBook(key);
			}
				});
	
	public static void loadAllAddresses() {
		addressCache.putAll(AddressAccess.getAllAddresses());
	}
	
	public static void loadAllEmployees() {
		employeeCache.putAll(EmployeeAccess.getAllEmployees());
	}
	
	public static void loadAllBooks() {
		bookCache.putAll(BookAccess.getAllBooks());
	}
	
}
