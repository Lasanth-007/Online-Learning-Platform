package learn.onlinelearningplatform.Service;

import jakarta.transaction.Transactional;
import learn.onlinelearningplatform.Entity.Course;
import learn.onlinelearningplatform.Entity.Section;
import learn.onlinelearningplatform.dto.section.SectionCreateDto;
import learn.onlinelearningplatform.dto.section.SectionPatchDto;
import learn.onlinelearningplatform.dto.section.SectionResponseDto;
import learn.onlinelearningplatform.mapper.SectionMapper;
import learn.onlinelearningplatform.repositories.CourseRepository;
import learn.onlinelearningplatform.repositories.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {

    private final SectionRepository sectionRepository;
    private final CourseRepository courseRepository;
    private final SectionMapper sectionMapper;

    // ==================== CREATE ====================
    @Transactional
    public SectionResponseDto createSection(SectionCreateDto dto) {
        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Section section = sectionMapper.toEntity(dto);
        section.setCourse(course);

        Section saved = sectionRepository.save(section);
        return sectionMapper.toResponseDto(saved);
    }

    // ==================== GET ALL BY COURSE ====================
    public List<SectionResponseDto> getSectionsByCourse(Long courseId) {
        List<Section> sections = sectionRepository.findByCourse_Id(courseId);
        return sectionMapper.toResponseDtoList(sections);
    }

    // ==================== GET BY ID ====================
    public SectionResponseDto getSectionById(Long id) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found"));
        return sectionMapper.toResponseDto(section);
    }

    // ==================== PUT - Full Update ====================
    @Transactional
    public SectionResponseDto updateSection(Long id, SectionCreateDto dto) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        sectionMapper.updateSectionFromDto(dto, section);
        section.setCourse(course);

        Section saved = sectionRepository.save(section);
        return sectionMapper.toResponseDto(saved);
    }

    // ==================== PATCH - Partial Update ====================
    @Transactional
    public SectionResponseDto patchSection(Long id, SectionPatchDto dto) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        sectionMapper.updateSectionFromPatch(dto, section);

        Section saved = sectionRepository.save(section);
        return sectionMapper.toResponseDto(saved);
    }

    // ==================== DELETE ====================
    @Transactional
    public void deleteSection(Long id) {
        if (!sectionRepository.existsById(id)) {
            throw new RuntimeException("Section not found");
        }
        sectionRepository.deleteById(id);
    }
}
