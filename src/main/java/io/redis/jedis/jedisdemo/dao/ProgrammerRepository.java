package io.redis.jedis.jedisdemo.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.redis.jedis.jedisdemo.model.Programmer;

public interface ProgrammerRepository {

	void setProgrammerAsString(String idKey, String programmer);

	String getProgrammerAsString(String idKey);

	void AddToProgrammersList(Programmer programmer);

	List<Programmer> getProgrammersListMembers();

	Long getProgrammersListCount();

	// Set

	void addtoProgrammersSet(Programmer... programmers);

	Set<Programmer> getProgrammersSetMembers();

	boolean isSetMember(Programmer programmer);

	// Hash
	void saveHash(Programmer programmer);

	void updateHash(Programmer programmer);

	Map<Integer, Programmer> findAllHash();

	Programmer findInHash(int id);

	void deleteHash(int id);
}
