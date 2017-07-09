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
    : ('a'..'z')+ ;

ARROW_LINE
    : '-->' ;

UML_START
    : '@startuml' ;

UML_END
    : '@enduml' ;

WS
    : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
