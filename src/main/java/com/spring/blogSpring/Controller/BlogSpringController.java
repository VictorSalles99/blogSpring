package com.spring.blogSpring.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.blogSpring.Model.Post;
import com.spring.blogSpring.Service.BlogSpringService;

@Controller
public class BlogSpringController {

	@Autowired
	BlogSpringService blogSpringService;

	@RequestMapping("/")
    public ModelAndView index(){
        return getPosts();
	}
	
	// retorno do html posts inicial (Listagem dos posts), passando "posts" que
	// seria o array de retorno da base
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = blogSpringService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}

	// retorno do html posts inicial (Detalhes dos posts), passando "post" por id
	// que seria o array de retorno da base
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = blogSpringService.findById(id);
		mv.addObject("post", post);
		return mv;
	}

	// retorno do html que sera pra cadastro de novos posts (não é passado parametro
	// nenhum).
	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			attribute.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/newPost";
		}
		post.setData(LocalDate.now());
		blogSpringService.save(post);
		return "redirect:/posts";
	}

}