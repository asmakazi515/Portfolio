package in.sp.main.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.sp.main.model.Project;
import in.sp.main.model.About;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        ObjectMapper mapper = new ObjectMapper();

        // Load about.json
        try (InputStream aboutStream = getClass().getResourceAsStream("/about.json")) {
            if (aboutStream != null) {
                About about = mapper.readValue(aboutStream, About.class);
                model.addAttribute("about", about);
            } else {
                System.err.println("about.json not found on classpath");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Load skills.json
        try (InputStream skillStream = getClass().getResourceAsStream("/skills.json")) {
            if (skillStream != null) {
                Map<String, List<String>> skill = mapper.readValue(skillStream, new TypeReference<>() {});
                model.addAttribute("skill", skill);
            } else {
                System.err.println("skills.json not found on classpath");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ Load certifications.json
        try (InputStream certStream = getClass().getResourceAsStream("/certifications.json")) {
            if (certStream != null) {
                List<Map<String, Object>> certifications = mapper.readValue(certStream, new TypeReference<>() {});
                model.addAttribute("certifications", certifications);
            } else {
                System.err.println("certifications.json not found on classpath");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "about";
    }


    @GetMapping("/projects")
    public String projects(Model model) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/projects.json")) {
            List<Project> projects = mapper.readValue(is, new TypeReference<List<Project>>() {});
            model.addAttribute("projects", projects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "projects";
    }

    // 🆕 Updated Skills Method (for Skills Page)
    @GetMapping("/skills")
    public String skills(Model model) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/skills.json")) {
            // read JSON as Map (category → list of skills)
            Map<String, List<String>> skills = mapper.readValue(is, new TypeReference<>() {});
            model.addAttribute("skills", skills);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "skills"; // maps to skills.html
    }

}
