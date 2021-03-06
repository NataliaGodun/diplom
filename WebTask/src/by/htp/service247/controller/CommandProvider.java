package by.htp.service247.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.service247.command.Command;
import by.htp.service247.command.impl.AddVentilaciaDemand;
import by.htp.service247.command.impl.AutorizationClient;
import by.htp.service247.command.impl.AutorizationContractor;
import by.htp.service247.command.impl.ChangeStatus;
import by.htp.service247.command.impl.CreateAct;
import by.htp.service247.command.impl.CreateActForm;
import by.htp.service247.command.impl.DeleteDemand;
import by.htp.service247.command.impl.EditDemand;
import by.htp.service247.command.impl.EditDemandForm;
import by.htp.service247.command.impl.EditStatus;
import by.htp.service247.command.impl.Exit;
import by.htp.service247.command.impl.GetImage;
import by.htp.service247.command.impl.Profil;
import by.htp.service247.command.impl.RegClient;
import by.htp.service247.command.impl.RegContractor;
import by.htp.service247.command.impl.SelectDepartmentForm;
import by.htp.service247.command.impl.ShowAddDemandForm;
import by.htp.service247.command.impl.ShowAllDemands;
import by.htp.service247.command.impl.ShowAllDemandsDepartment;
import by.htp.service247.command.impl.ShowCommercialPage;
import by.htp.service247.command.impl.ShowElectro;
import by.htp.service247.command.impl.ShowLoginFormClient;
import by.htp.service247.command.impl.ShowLoginFormContractor;
import by.htp.service247.command.impl.ShowRegFormClient;
import by.htp.service247.command.impl.ShowRegFormContractor;
import by.htp.service247.command.impl.TakeKP;
import by.htp.service247.command.impl.VentilaciaDemand;
import by.htp.service247.command.impl.ViewDemand;
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
		commands.put(CommandName.VENTILACIADEMAND, new VentilaciaDemand());
		commands.put(CommandName.ADDVENTILACIADEMAND, new AddVentilaciaDemand());
		commands.put(CommandName.SHOWALLDEMANS, new ShowAllDemands());
		commands.put(CommandName.SHOWALLDEMANDSDEPARTMENT, new ShowAllDemandsDepartment());
		commands.put(CommandName.DELETEDEMAND, new DeleteDemand());
		commands.put(CommandName.EDITDEMAND, new EditDemand());
		commands.put(CommandName.EDITDEMANDFORM, new EditDemandForm());
		commands.put(CommandName.VIEWDEMAND, new ViewDemand());
		commands.put(CommandName.GETIMAGE, new GetImage());
		commands.put(CommandName.CHANGESTATUS, new ChangeStatus());
		commands.put(CommandName.EDITSTATUS, new EditStatus());
		commands.put(CommandName.TAKEKP, new TakeKP());
		commands.put(CommandName.SHOWREGFORMCONTRACTOR, new ShowRegFormContractor());
		commands.put(CommandName.REGCONTRACTOR, new RegContractor());
		commands.put(CommandName.CREATEACT, new CreateAct());
		commands.put(CommandName.SHOWELECTRO, new ShowElectro());
		commands.put(CommandName.PROFIL, new Profil());
		commands.put(CommandName.CREATEACTFORM, new CreateActForm());
		commands.put(CommandName.SHOWREGFORMCLIENT, new ShowRegFormClient());
		commands.put(CommandName.REGCLIENT, new RegClient());
		commands.put(CommandName.EXIT, new Exit());
	
	

	}

	public Command getCommand(String commandName) {
		commandName = commandName.toUpperCase();
		return commands.get(CommandName.valueOf(commandName));
	}
}
