grammar Sample;

// source: https://github.com/cloverrose/ANTLRv4Sample/blob/master/Sample.g4

prog
    : stat+
    ;

stat
    : exprAssign
    | formulaAssign
    | tupleAssign
    ;

exprAssign
    : ID '=' expr ';'
    ;

formulaAssign
    : ID '=' formula ';'
    ;

tupleAssign
    : ID '=' '(' (element (',' element)*)? ')' ';'
    ;

element
    : expr
    | formula
    ;

expr
    : expr (MUL | DIV) expr
    | expr (ADD | SUB) expr
    | INT
    | ID
    | '(' expr ')'
    ;

formula
    : '!' formula
    | formula '&&' formula
    | formula '->' formula
    | formula '||' formula
    | formula '<->' formula
    | 'true'
    | 'false'
    | ID
    | '(' formula ')'
    ;

INT
    : ('0'..'9')+
    ;

ID
    : ('a'..'z')+
    ;

ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';

WS
    : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
