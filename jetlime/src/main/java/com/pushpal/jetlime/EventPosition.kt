package com.pushpal.jetlime

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

/**
 * Represents a position of an event within a sequence, such as the start, middle, or end.
 * This class encapsulates the logic for determining the position based on the index in a list.
 *
 * @property name The name of the event position.
 */
@Immutable
class EventPosition private constructor(val name: String) {
  companion object {

    /** Represents the start position in a sequence. */
    val START = EventPosition("Start")

    /** Represents the middle position in a sequence. */
    val MIDDLE = EventPosition("Middle")

    /** Represents the end position in a sequence. */
    val END = EventPosition("End")

    /**
     * Determines the event position dynamically based on the index and the size of the list.
     *
     * @param index The index of the item in the list.
     * @param listSize The total size of the list.
     * @return [EventPosition] corresponding to the index in the list.
     */
    @Stable
    fun dynamic(
      index: Int,
      listSize: Int
    ) = eventPosition(index, listSize)

    /**
     * Internal function to determine the event position based on index and list size.
     */
    @Stable
    private fun eventPosition(
      index: Int,
      listSize: Int
    ) = when (index) {
      0 -> START
      listSize - 1 -> END
      else -> MIDDLE
    }
  }

  /**
   * A helper function to check if the current position is not the end position.
   * This can be useful for determining layout or drawing logic based on the position of an event.
   *
   * @return `true` if the current position is not the end, `false` otherwise.
   */
  @Stable
  fun isNotEnd(): Boolean {
    return this != END
  }

  /**
   * Checks if this instance is equal to another object. Two instances of [EventPosition] are
   * considered equal if they have the same name.
   *
   * @param other The object to compare this instance with.
   * @return `true` if the other object is an instance of [EventPosition] and has the same name, `false` otherwise.
   */
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is EventPosition) return false
    return name == other.name
  }

  /**
   * Returns a hash code value for the object, which is consistent with the definition of equality for the class.
   * This supports the use in hash tables, like those provided by `HashMap`.
   *
   * @return A hash code value for this object.
   */
  override fun hashCode(): Int {
    return name.hashCode()
  }
}