package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Teacher;

public class TeacherAccess extends RestRequest {
	public static Teacher get(Integer teacherId) throws IOException, URISyntaxException {
		String JSONTeacher = getAllOrOne(new URI(Constants.TEACHER_SOURCE + teacherId));
		Teacher teacher = mapper.readValue(JSONTeacher, Teacher.class);
		return teacher;
	}

	public static HashMap<Integer, Teacher> getAll() throws IOException, URISyntaxException {
		String JSONTeacher = getAllOrOne(new URI(Constants.TEACHER_SOURCE));
		List<Teacher> teachers = mapper.readValue(JSONTeacher, new TypeReference<List<Teacher>>() {
		});

		HashMap<Integer, Teacher> teachersMap = new HashMap<Integer, Teacher>();

		for (Teacher teacher : teachers) {
			teachersMap.put(teacher.getTeacherId(), teacher);
		}
		return teachersMap;
	}

	public static Teacher add(Teacher teacher) throws IOException, URISyntaxException {
		String JSONTeacher = postObject(teacher, new URI(Constants.TEACHER_SOURCE));
		return mapper.readValue(JSONTeacher, Teacher.class);
	}

	public static void update(Teacher teacher) throws URISyntaxException, IOException {
		putObject(teacher, new URI(Constants.TEACHER_SOURCE + teacher.getTeacherId()));
	}

	public static Teacher remove(Integer id) throws URISyntaxException, IOException {
		String JSONTeacher = deleteObject(id, new URI(Constants.TEACHER_SOURCE + id));
		return mapper.readValue(JSONTeacher, Teacher.class);
	}
}
