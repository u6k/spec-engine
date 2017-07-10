grammar PlantUml;

plantuml
    : UML_START statement* UML_END
    ;

statement
    : STATE_START ARROW_LINE ID
    ;

STATE_START
    : '[*]' ;

ID
    : ID_LETTER ID_LETTER_DIGIT* ;

fragment
ID_LETTER
    : [a-zA-Z$_]
    | ~[\u0000-\u007F\uD800-\uDBFF]
      {Character.isJavaIdentifierStart(_input.LA(-1))}?
    | [\uD800-\uDBFF] [\uDC00-\uDFFF]
      {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment
ID_LETTER_DIGIT
    : [a-zA-Z0-9$_]
    | ~[\u0000-\u007F\uD800-\uDBFF]
      {Character.isJavaIdentifierPart(_input.LA(-1))}?
    | [\uD800-\uDBFF] [\uDC00-\uDFFF]
      {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

ARROW_LINE
    : '-->' ;

UML_START
    : '@startuml' ;

UML_END
    : '@enduml' ;

WS
    : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
