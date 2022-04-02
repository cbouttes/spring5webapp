package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Author controller.
 */
@Controller
public class AuthorController {

    /**
     * The Author repository.
     */
    public final AuthorRepository authorRepository;

    /**
     * Instantiates a new Author controller.
     *
     * @param authorRepository the author repository
     */
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Gets authors.
     *
     * @param model the model
     * @return the authors
     */
    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }

}
