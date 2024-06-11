
CREATE TABLE "ROUTINE" (
	codRoutine INTEGER ,
	name TEXT,
	description TEXT,
	dateStart TEXT,
	dateFinish TEXT NOT NULL,
	daysCount INTEGER,
	codUser INTEGER NOT NULL,
	CONSTRAINT ROUTINE_PK PRIMARY KEY (codRoutine)
);

