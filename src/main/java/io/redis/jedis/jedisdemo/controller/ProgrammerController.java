package io.redis.jedis.jedisdemo.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.redis.jedis.jedisdemo.model.Programmer;
import io.redis.jedis.jedisdemo.service.ProgrammerService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ProgrammerController {

	@Autowired
	ProgrammerService programmerService;

	@PostMapping("/programmer-string")
	@ApiOperation("Add Programmer")
	public void addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
				mapper.writeValueAsString(programmer));

	}

	@GetMapping("/programmer-string/{id}")
	@ApiOperation("Get Programmer")
	public String readString(@PathVariable String id) {

		return programmerService.getProgrammerAsString(id);
	}

	@PostMapping("/programmer-list")
	@ApiOperation("Add Programmer to List")
	public void addToProgrammerList(@RequestBody Programmer programmer) {

		programmerService.addToProgrammersList(programmer);
	}

	@GetMapping("/programmers-list")
	@ApiOperation("List Programmers")
	public List<Programmer> getProgrammerListMembers() {

		return programmerService.getProgrammersListMembers();

	}

	@GetMapping("/programmers-list/count")
	@ApiOperation("get total of programmers")
	public Long getProgrammerListCount() {

		return programmerService.getProgrammersListCount();
	}

	@ApiOperation("Add Programmer to Set")
	@PostMapping("/programmers-set")
	public void addToProgrammersSet(@RequestBody Programmer... programmers) {

		programmerService.addtoProgrammersSet(programmers);

	}

	@ApiOperation("List Programmers by using Set")
	@GetMapping("/programmers-set")
	public Set<Programmer> getProgrammersSetMembers() {

		return programmerService.getProgrammersSetMembers();
	}

	@ApiOperation("check member in Set")
	@PostMapping("/programmers-set/member")
	public boolean isSetMember(@RequestBody Programmer programmer) {

		return programmerService.isSetMember(programmer);
	}

	@PostMapping("/programmers-hash")
	@ApiOperation("add programmer to hash")
	public void saveHash(@RequestBody Programmer programmer) {

		programmerService.saveHash(programmer);

	}

	@PutMapping("/programmers-hash")
	@ApiOperation("update programmer in hash")
	public void updateHash(@RequestBody Programmer programmer) {

		programmerService.updateHash(programmer);
	}
	@ApiOperation("get all programmers from hash")
	@GetMapping("/programmers-hash")
	public Map<Integer, Programmer> findAllHash() {

		return programmerService.findAllHash();

	}
	@ApiOperation("delete programmer from hash")
	@DeleteMapping("/programmers-hash/{id}")
	public void deleteHash(@PathVariable int id) {

		programmerService.deleteHash(id);

	}

}
