package com.Loki.factories;

import com.Loki.action.AccountAction;

public class AccountActionFactory {
   private static AccountAction accountAction=null;
  static {
	  accountAction=new AccountAction();
  }
  public static AccountAction getAccountAction() {
	

	  return accountAction;
  }
}
