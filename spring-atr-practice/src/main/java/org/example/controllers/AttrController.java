package org.example.controllers;

import org.example.dtos.attr.UpdateAttrRequestDto;
import org.example.services.AttrService;
import org.example.dtos.attr.UpdateAttrResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attr")
public class AttrController {

    @Autowired
    AttrService attrService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getAttr(@PathVariable(name = "id") String id) {
        String response = attrService.getAttrById(id);
        if (response == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateAttrResponseDto> updateAttr(
            @PathVariable(name = "id", required = true) String id,
            @RequestBody UpdateAttrRequestDto updateRequest
    ) {

//        System.out.println(updateRequest);
        UpdateAttrResponseDto attrResponse = attrService.updateAttr(id, updateRequest);
        return ResponseEntity.ok(attrResponse);
    }

    @PutMapping("/parallel/{id}")
    public ResponseEntity<List<Object>> concurrentCall(
            @PathVariable(name = "id", required = true) String id,
            @RequestBody UpdateAttrRequestDto updateRequest
    ){
        List<Object> response = attrService.parallelCall(id, updateRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/test")
    public ResponseEntity<UpdateAttrRequestDto> test(
            @RequestBody UpdateAttrRequestDto request
    ){
//        System.out.println(request);
        return ResponseEntity.ok(request);
    }

}
