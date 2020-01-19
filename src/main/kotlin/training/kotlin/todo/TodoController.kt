package training.kotlin.todo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("todo")
class TodoController @Autowired constructor(private val todoService: TodoService) {

    @GetMapping("/")
    fun showTodo(model: Model): String = show(model)

    @GetMapping("/create")
    fun createTodo(model: Model, @RequestParam name: String): String {
        todoService.create(Todo(name = name))
        return show(model)
    }

    @GetMapping("/delete")
    fun deleteTodo(model: Model, @RequestParam id: Int): String {
        todoService.delete(id)
        return show(model)
    }

    private fun show(model: Model): String {
        model.addAttribute("todoList", todoService.findAll())
        return "todo"
    }
}