package org.example.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class BasicOperationsTest {

	@Test
	void testAddition() {
		int result = 2 + 3;
		assertThat(result).isEqualTo(5);
	}

	@Test
	void testInsertion_Integer() {
		Integer[] arr_insertion = { 1, 2, 3, 4, 5 };
		assertThat(BasicOperations.insert(arr_insertion, 2, 6)).containsExactly(1, 2, 6, 3, 4, 5);
		assertThat(BasicOperations.insert(arr_insertion, 0, 6)).containsExactly(6, 1, 2, 3, 4, 5);
		assertThat(BasicOperations.insert(arr_insertion, 5, 6)).containsExactly(1, 2, 3, 4, 5, 6);

		assertThatThrownBy(() -> BasicOperations.insert(arr_insertion, 10, 6))
				.isInstanceOf(ArrayIndexOutOfBoundsException.class)
				.hasMessageContaining("Index 10 is out of bounds!");

		assertThatThrownBy(() -> BasicOperations.insert(arr_insertion, -1, 6))
				.isInstanceOf(ArrayIndexOutOfBoundsException.class)
				.hasMessageContaining("Index -1 is out of bounds!");
	}

	@Test
	void testInsertion_String() {
		String[] arr_insertion = { "a", "b", "c", "d", "e" };
		assertThat(BasicOperations.insert(arr_insertion, 3, "f")).containsExactly("a", "b", "c", "f", "d", "e");
		assertThat(BasicOperations.insert(arr_insertion, 0, "f")).containsExactly("f", "a", "b", "c", "d", "e");
		assertThat(BasicOperations.insert(arr_insertion, 5, "f")).containsExactly("a", "b", "c", "d", "e", "f");

		assertThatThrownBy(() -> BasicOperations.insert(arr_insertion, 10, "f"))
				.isInstanceOf(ArrayIndexOutOfBoundsException.class)
				.hasMessageContaining("Index 10 is out of bounds!");

		assertThatThrownBy(() -> BasicOperations.insert(arr_insertion, -1, "f"))
				.isInstanceOf(ArrayIndexOutOfBoundsException.class)
				.hasMessageContaining("Index -1 is out of bounds!");
	}

	@Test
	void testDeletion_Integer() {
		Integer[] arr_del = { 1, 2, 3, 4, 5 };
		assertThat(BasicOperations.delete(arr_del, 2)).containsExactly(1, 2, 4, 5);
		assertThat(BasicOperations.delete(arr_del, 0)).containsExactly(2, 3, 4, 5);
		assertThat(BasicOperations.delete(arr_del, 4)).containsExactly(1, 2, 3, 4);

		assertThatThrownBy(() -> BasicOperations.delete(arr_del, 10))
				.isInstanceOf(ArrayIndexOutOfBoundsException.class)
				.hasMessageContaining("Index 10 is out of bounds!");

		assertThatThrownBy(() -> BasicOperations.delete(arr_del, -1))
				.isInstanceOf(ArrayIndexOutOfBoundsException.class)
				.hasMessageContaining("Index -1 is out of bounds!");
	}

	@Test
	void testDeletion_String() {
		String[] arr_del = { "a", "b", "c", "d", "e" };
		assertThat(BasicOperations.delete(arr_del, 3)).containsExactly("a", "b", "c", "e");
		assertThat(BasicOperations.delete(arr_del, 0)).containsExactly("b", "c", "d", "e");
		assertThat(BasicOperations.delete(arr_del, 4)).containsExactly("a", "b", "c", "d");

		assertThatThrownBy(() -> BasicOperations.delete(arr_del, 10))
				.isInstanceOf(ArrayIndexOutOfBoundsException.class)
				.hasMessageContaining("Index 10 is out of bounds!");

		assertThatThrownBy(() -> BasicOperations.delete(arr_del, -1))
				.isInstanceOf(ArrayIndexOutOfBoundsException.class)
				.hasMessageContaining("Index -1 is out of bounds!");
	}

	@Test
	void testSearchByValueReturnIndex_Integer() {
		Integer[] arr_search = { 1, 2, 3, 4, 5 };
		assertThat(BasicOperations.searchByValueReturnIndex(arr_search, 2)).isEqualTo(1);
		assertThat(BasicOperations.searchByValueReturnIndex(arr_search, 3)).isEqualTo(2);
		assertThat(BasicOperations.searchByValueReturnIndex(arr_search, 6)).isEqualTo(-1);
	}

	@Test
	void testSearchByValueReturnIndex_String() {
		String[] arr_search = { "a", "b", "c", "d", "e" };
		assertThat(BasicOperations.searchByValueReturnIndex(arr_search, "b")).isEqualTo(1);
		assertThat(BasicOperations.searchByValueReturnIndex(arr_search, "c")).isEqualTo(2);
		assertThat(BasicOperations.searchByValueReturnIndex(arr_search, "f")).isEqualTo(-1);
	}
}
