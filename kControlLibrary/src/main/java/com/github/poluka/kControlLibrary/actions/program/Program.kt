package com.github.poluka.kControlLibrary.actions.program

import com.github.poluka.kControlLibrary.actions.Command
import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot

@ExecutedOnTheRobot
class Program : Command, MutableList<Command> {
    private val commandList = mutableListOf<Command>()
    
    operator fun invoke(addCommands: Program.() -> Unit){
        addCommands()
    }

    override fun run(): String {
        var command = ""
        if(commandList.isNotEmpty()){
            commandList.forEach {
                command += it.run() + "%"
            }
        }
        return command
    }
    fun getAll(): List<Command> = commandList

    override fun contains(element: Command): Boolean = commandList.contains(element)

    override fun containsAll(elements: Collection<Command>): Boolean = commandList.containsAll(elements)

    override fun get(index: Int): Command = commandList[index]

    override fun indexOf(element: Command): Int = commandList.indexOf(element)

    override fun isEmpty(): Boolean = commandList.isEmpty()

    override fun iterator(): MutableIterator<Command> = commandList.iterator()

    override fun lastIndexOf(element: Command): Int = commandList.lastIndexOf(element)

    override fun add(index: Int, element: Command) = commandList.add(index, element)

    override fun addAll(index: Int, elements: Collection<Command>): Boolean
            = commandList.addAll(index, elements)

    override fun addAll(elements: Collection<Command>): Boolean
            = commandList.addAll(elements)

    override fun clear() = commandList.clear()

    override fun listIterator(): MutableListIterator<Command> = commandList.listIterator()

    override fun listIterator(index: Int): MutableListIterator<Command>
            = commandList.listIterator(index)

    override fun removeAll(elements: Collection<Command>): Boolean
            = commandList.removeAll(elements)

    override fun removeAt(index: Int): Command
            = commandList.removeAt(index)

    override fun retainAll(elements: Collection<Command>): Boolean
            = commandList.retainAll(elements)

    override fun set(index: Int, element: Command): Command
            = commandList.set(index, element)

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<Command>
            = commandList.subList(fromIndex, toIndex)

    override fun add(element: Command): Boolean = commandList.add(element)

    override fun remove(element: Command): Boolean = commandList.remove(element)

    override val size: Int
        get() = commandList.size
}