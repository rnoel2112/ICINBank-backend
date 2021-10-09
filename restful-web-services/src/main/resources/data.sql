
insert IGNORE into account (Id, username,account_id,is_saving,activity,transaction_date,is_credit,amount,balance) 
	values (1, 'simplilearn', 'Acct-001', true, 'Deposit','2021/12/12',false,10,20);

insert IGNORE into userprofile (`id`,`username`,`national_id`,`date_of_birth`,`passowrd`,`banking_restriction`,`check_book_request`)
	values (1, 'simplilearn', 'ND-001', '2021/12/12','admin',false,false);
