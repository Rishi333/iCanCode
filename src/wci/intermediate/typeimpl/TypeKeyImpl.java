package wci.intermediate.typeimpl;

import wci.intermediate.TypeKey;

/**
 * <h1>TypeKeyImpl</h1>
 *
 * <p>Attribute keys for a Pascal type specification.</p>
 *
 * <p>Copyright (c) 2008 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public enum TypeKeyImpl implements TypeKey
{
    // Enumeration
    ENUMERATION_CONSTANTS,

    // Subrange
    SUBRANGE_BASE_TYPE, SUBRANGE_MIN_VALUE, SUBRANGE_MAX_VALUE,

    // Array
    ARRAY_INDEX_TYPE, ARRAY_ELEMENT_TYPE, ARRAY_ELEMENT_COUNT,
    
    // Array
    LIST_INDEX_TYPE,LIST_ELEMENT_TYPE, LIST_ELEMENT_COUNT,
    
    // Array
    SET_INDEX_TYPE,SET_ELEMENT_TYPE, SET_ELEMENT_COUNT,
  
    // Array
    MAP_INDEX_TYPE, MAP_KEY_TYPE,MAP_VALUE_TYPE, MAP_ELEMENT_COUNT,

    // Record
    RECORD_SYMTAB
}
