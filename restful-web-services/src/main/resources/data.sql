
insert IGNORE into account (Id, username,account_id,is_saving,activity,transaction_date,is_credit,amount,balance) 
	values (2000, 'simplilearn', 'Acct-001', true, 'Deposit','2021/10/10',false,10,20);
insert IGNORE into account (Id, username,account_id,is_saving,activity,transaction_date,is_credit,amount,balance) 
	values (2001, 'reliance', 'Acct-012', true, 'Deposit','2021/10/10',false,20,1000);

	
insert IGNORE into userprofile (`id`,`username`,`national_id`,`date_of_birth`,`password`,`banking_restriction`,`check_book_request`,`is_admin`)
	values (2000, 'simplilearn', 'ND-001', '2021/10/10','admin',false,false,true);
insert IGNORE into userprofile (`id`,`username`,`national_id`,`date_of_birth`,`password`,`banking_restriction`,`check_book_request`,`is_admin`)
	values (2001, 'reliance', 'ND-011', '2021/10/10','password',false,false,false);
