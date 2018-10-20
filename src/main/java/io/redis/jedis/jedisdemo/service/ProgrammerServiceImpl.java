package io.redis.jedis.jedisdemo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redis.jedis.jedisdemo.dao.ProgrammerRepository;
import io.redis.jedis.jedisdemo.model.Programmer;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

	@Autowired
	ProgrammerRepository programmerRepository;

	@Override
	public void setProgrammerAsString(String idKey, String programmer) {

		programmerRepository.setProgrammerAsString(idKey, programmer);
	}

	@Override
	public String getProgrammerAsString(String idKey) {

		return programmerRepository.getProgrammerAsString(idKey);
	}

	@Override
	public void addToProgrammersList(Programmer programmer) {
		programmerRepository.AddToProgrammersList(programmer);

	}

	@Override
	public List<Programmer> getProgrammersListMembers() {

		return programmerRepository.getProgrammersListMembers();
	}

	@Override
	public Long getProgrammersListCount() {

		return programmerRepository.getProgrammersListCount();
	}

	@Override
	public void addtoProgrammersSet(Programmer... programmers) {
		programmerRepository.addtoProgrammersSet(programmers);

	}

	@Override
	public Set<Programmer> getProgrammersSetMembers() {

		return programmerRepository.getProgrammersSetMembers();
	}

	@Override
	public boolean isSetMember(Programmer programmer) {

		return programmerRepository.isSetMember(programmer);
	}

	@Override
	public void saveHash(Programmer programmer) {

		programmerRepository.saveHash(programmer);
	}

	@Override
	public void updateHash(Programmer programmer) {
		programmerRepository.updateHash(programmer);

	}

	@Override
	public Map<Integer, Programmer> findAllHash() {

		return programmerRepository.findAllHash();
	}

	@Override
	public Programmer findInHash(int id) {

		return programmerRepository.findInHash(id);
	}

	@Override
	public void deleteHash(int id) {
		programmerRepository.deleteHash(id);
	}

}
