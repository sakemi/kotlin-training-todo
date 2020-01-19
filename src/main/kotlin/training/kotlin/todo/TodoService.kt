package training.kotlin.todo

import org.springframework.stereotype.Service

@Service
class TodoService constructor(val repository: TodoRepository) {
    fun findAll(): MutableList<Todo> = repository.findAll()
    fun create(todo: Todo) = repository.save(todo)
    fun delete(id: Int) = repository.deleteById(id)
}