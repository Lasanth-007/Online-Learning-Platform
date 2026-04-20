package learn.onlinelearningplatform.controller;

import learn.onlinelearningplatform.Service.SectionService;
import learn.onlinelearningplatform.dto.section.SectionCreateDto;
import learn.onlinelearningplatform.dto.section.SectionPatchDto;
import learn.onlinelearningplatform.dto.section.SectionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
@RequiredArgsConstructor
public class SectionController {

    private final SectionService sectionService;

    @PostMapping
    public ResponseEntity<SectionResponseDto> createSection(@RequestBody SectionCreateDto dto) {
        SectionResponseDto created = sectionService.createSection(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<SectionResponseDto>> getSectionsByCourse
    (@PathVariable Long courseId) {
        List<SectionResponseDto> sections = sectionService.getSectionsByCourse(courseId);
        return ResponseEntity.ok(sections);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionResponseDto> getSectionById(@PathVariable Long id) {
        SectionResponseDto section = sectionService.getSectionById(id);
        return ResponseEntity.ok(section);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectionResponseDto> updateSection(
            @PathVariable Long id,
            @RequestBody SectionCreateDto dto) {

        SectionResponseDto updated = sectionService.updateSection(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SectionResponseDto> patchSection(
            @PathVariable Long id,
            @RequestBody SectionPatchDto dto) {

        SectionResponseDto updated = sectionService.patchSection(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
        return ResponseEntity.noContent().build();
    }
}
