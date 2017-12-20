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
import models.FollowingTraining;
import models.Teacher;
import models.TrainingInfo;
import models.TrainingSession;
import models.Book;
import models.SurveyAnswer;
import models.SurveyQuestion;
import models.Survey;
import models.FollowingTraining;


//Source: https://www.tutorialspoint.com/guava/guava_caching_utilities.htm
public class Cache {
	public static LoadingCache<Integer, Survey> surveyCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, Survey>() {
				@Override
				public Survey load(Integer key) throws Exception {
					return SurveyAcces.get(key);
				}
			});
	
	public static LoadingCache<Integer, SurveyAnswer> surveyAnswerCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, SurveyAnswer>() {
				@Override
				public SurveyAnswer load(Integer key) throws Exception {
					return SurveyAnswerAcces.get(key);
				}
			});
	public static LoadingCache<Integer, SurveyQuestion> surveyQuestionCache = CacheBuilder.newBuilder().maximumSize(500)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, SurveyQuestion>() {
				@Override
				public SurveyQuestion load(Integer key) throws Exception {
					return SurveyQuestionAcces.get(key);
				}
			});
	public static LoadingCache<Integer, Address> addressCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, Address>() {
				@Override
				public Address load(Integer key) throws Exception {
					return AddressAccess.get(key);
				}
			});
	public static LoadingCache<Integer, Employee> employeeCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, Employee>() {

				@Override
				public Employee load(Integer key) throws Exception {
					return EmployeeAccess.get(key);
				}
			});
	
	
	public static LoadingCache<Integer, Certificate> certificateCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, Certificate>() {

				@Override
				public Certificate load(Integer key) throws Exception {
					return CertificateAccess.get(key);
				}
			});
	public static LoadingCache<Integer, Faq> faqCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, Faq>() {

				@Override
				public Faq load(Integer key) throws Exception {
					return FaqAccess.get(key);
				}
			});
	public static LoadingCache<Integer, Teacher> teacherCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, Teacher>() {

				@Override
				public Teacher load(Integer key) throws Exception {
					return TeacherAccess.get(key);
				}
			});
	public static LoadingCache<Integer, TrainingInfo> trainingInfoCache = CacheBuilder.newBuilder().maximumSize(300)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, TrainingInfo>() {

				@Override
				public TrainingInfo load(Integer key) throws Exception {
					return TrainingInfoAccess.get(key);
				}
			});

	/*
	 public static LoadingCache<Integer,FollowingTraining> followingTraingCache = CacheBuilder.newBuilder().maximumSize(100)
					.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, FollowingTraining>() {
                @Override
                public FollowingTraining load(Integer key) throws Exception {
                    return FollowingTraingAcces.get(key);
                }
            });
    */
	
	public static LoadingCache<Integer, TrainingSession> trainingSessionCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Integer, TrainingSession>() {

				@Override
				public TrainingSession load(Integer key) throws Exception {
					return TrainingSessionAccess.get(key);
				}
			});
	
	public static void loadAllSurverQuestions() throws IOException, URISyntaxException {
		surveyQuestionCache.putAll(SurveyQuestionAcces.getAllSurveyQuestions());
	}
	public static void loadAllSurveyAnswers () throws IOException, URISyntaxException {
		surveyAnswerCache.putAll(SurveyAnswerAcces.getAllSurveyAnswers());
	}	

	public static LoadingCache<Long, Book> bookCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterAccess(30, TimeUnit.MINUTES).build(new CacheLoader<Long, Book>() {
				@Override
				public Book load(Long key) throws Exception {
					return BookAccess.get(key);
				}
			});
	
	public static void loadAllSurveys() throws IOException, URISyntaxException {
		surveyCache.putAll(SurveyAcces.getAllSurveys());
	}
	public static void loadAllSurveysQuestions() throws IOException, URISyntaxException {
		surveyQuestionCache.putAll(SurveyQuestionAcces.getAllSurveyQuestions());
	}
	public static void loadAllSurveysAnswers() throws IOException, URISyntaxException {
		surveyAnswerCache.putAll(SurveyAnswerAcces.getAllSurveyAnswers());
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
	
	public static void loadAllTeachers() throws IOException, URISyntaxException {
		teacherCache.putAll(TeacherAccess.getAll());
	}
	
	public static void loadAllTrainingInfos() throws IOException, URISyntaxException {
		trainingInfoCache.putAll(TrainingInfoAccess.getAll());
	}
	
	public static void loadAllTrainingSessions() throws IOException, URISyntaxException {
		trainingSessionCache.putAll(TrainingSessionAccess.getAll());
	}
  public static void loadAllAddresses() throws IOException, URISyntaxException {
		addressCache.putAll(AddressAccess.getAll());
  }
	
	public static void loadAllBooks() throws IOException, URISyntaxException {
		bookCache.putAll(BookAccess.getAll());
	}
	
<<<<<<< HEAD
	/*public static void loadAllFollowingTraining() throws IOException, URISyntaxException {
        followingTraingCache.putAll(FollowingTraingAcces.getAll());
    }*/
=======
>>>>>>> refs/remotes/origin/master
}
