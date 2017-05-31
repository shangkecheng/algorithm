import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by lucaskc on 2017/5/27.
 */

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

//    @Test(expected = RuntimeException.class)

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void  test1(){
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        System.out.println(mockedList.get(999));
        //following throws runtime exception
        //System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed


        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");
        System.out.println(mockedList.get(999));

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        verify(mockedList).add("once");
        //verify(mockedList, times(2)).add("once");
        verify(mockedList, never()).add("never happened");
        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        //when(mockedList.contains(argThat(isValid()))).thenReturn("element");

        List mock = mock(List.class, RETURNS_SMART_NULLS);

        //calling unstubbed method here:
        Object stuff = mock.get(0);

    }


    @Test
    public void usingMockito_UsingBDD() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        //given
        given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

        //when
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");

        //then
        Assert.assertThat(todos.size(), is(2));
    }
    @Test
    public void usingMockito() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }

    @Test
    public void captureArgument() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
        Mockito.verify(todoService).deleteTodo(stringArgumentCaptor.capture());

        assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
    }

    @Test
    public  void test2(){

        List list = new LinkedList();
        List spy = spy(list);

        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        //using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        //prints "one" - the first element of a list
        System.out.println(spy.get(0));

        //size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        //optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");
    }

    public static class TodoBusinessImpl {
        private TodoService todoService;

        TodoBusinessImpl(TodoService todoService) {
            this.todoService = todoService;
        }

        public List<String> retrieveTodosRelatedToSpring(String user) {
            List<String> filteredTodos = new ArrayList<String>();
            List<String> allTodos = todoService.retrieveTodos(user);
            for (String todo : allTodos) {
                if (todo.contains("Spring")) {
                    filteredTodos.add(todo);
                }
            }
            return filteredTodos;
        }

        public void deleteTodosNotRelatedToSpring(String user) {
            List<String> allTodos = todoService.retrieveTodos(user);
            for (String todo : allTodos) {
                if (!todo.contains("Spring")) {
                    todoService.deleteTodo(todo);
                }
            }
        }
    }

    public interface TodoService {

        public List<String> retrieveTodos(String user);

        void deleteTodo(String todo);

    }

    @Test
    public void test3(){

        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);
        //using mocks - only mockOne is interacted
        mockOne.add("one");

//ordinary verification
        verify(mockOne).add("one");

//verify that method was never called on a mock
        verify(mockOne, never()).add("two");

//verify that other mocks were not interacted
        verifyZeroInteractions(mockTwo, mockTwo);
    }

    @Test
    public void argumentmatcherTest(){
        List mock = mock(List.class);

        when(mock.addAll(argThat(new ListOfTwoElements()))).thenReturn(true);

        mock.addAll(Arrays.asList("one", "two"));

        verify(mock).addAll(argThat(list -> list.size() == 2));
    }

    class ListOfTwoElements implements ArgumentMatcher<List> {
        public boolean matches(List list) {
            return list.size() == 2;
        }
        public String toString() {
            //printed in verification errors
            return "[list of 2 elements]";
        }
    }

}
