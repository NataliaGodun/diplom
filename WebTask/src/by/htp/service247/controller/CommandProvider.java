package by.htp.service247.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.service247.command.Command;
import by.htp.service247.command.impl.AddVentilaciaDemand;
import by.htp.service247.command.impl.AutorizationClient;
import by.htp.service247.command.impl.AutorizationContractor;
import by.htp.service247.command.impl.DeleteDemand;
import by.htp.service247.command.impl.Exit;
import by.htp.service247.command.impl.GetImage;
import by.htp.service247.command.impl.Registration;
import by.htp.service247.command.impl.SelectDepartmentForm;
import by.htp.service247.command.impl.ShowAddDemandForm;
import by.htp.service247.command.impl.ShowAllDemands;
import by.htp.service247.command.impl.ShowCommercialPage;
import by.htp.service247.command.impl.ShowEditProfileForm;
import by.htp.service247.command.impl.ShowLoginFormClient;
import by.htp.service247.command.impl.ShowLoginFormContractor;
import by.htp.service247.command.impl.ShowRegistrationForm;
import by.htp.service247.command.impl.VentilaciaDemandForm;
import by.htp.service247.command.impl.ViewPageServices;



/**
 * @author Godun Natalia
 * @version 1.0
 */
public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.VIEWPAGESERVICES, new ViewPageServices());
		commands.put(CommandName.SHOWLOGINFORMCLIENT, new ShowLoginFormClient());
		commands.put(CommandName.AUTHORIZATIONCLIENT, new AutorizationClient());
		commands.put(CommandName.SHOWLOGINFORMCONTRACTOR, new ShowLoginFormContractor());
		commands.put(CommandName.AUTHORIZATIONCONTRACTOR, new AutorizationContractor());
		commands.put(CommandName.SHOWCOMMERCIALPAGE, new ShowCommercialPage());
		commands.put(CommandName.SHOWADDDEMANDFORM, new ShowAddDemandForm());
		commands.put(CommandName.SELECTDEPARTMENTFORM, new SelectDepartmentForm());
		commands.put(CommandName.VENTILACIADEMAND, new VentilaciaDemandForm());
		commands.put(CommandName.ADDVENTILACIADEMAND, new AddVentilaciaDemand());
		commands.put(CommandName.SHOWALLDEMANS, new ShowAllDemands());
		commands.put(CommandName.DELETEDEMAND, new DeleteDemand());
		commands.put(CommandName.REGISTRATION, new Registration());
		
		commands.put(CommandName.EXIT, new Exit());
	
		commands.put(CommandName.SHOWEDITPROFILEFORM, new ShowEditProfileForm());
		
		commands.put(CommandName.SHOWREGISTRATIONFORM, new ShowRegistrationForm());
		

	}

	public Command getCommand(String commandName) {
		commandName = commandName.toUpperCase();
		return commands.get(CommandName.valueOf(commandName));
	}
}
