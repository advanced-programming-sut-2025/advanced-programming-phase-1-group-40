package org.example.models.enums.commands;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public interface Command {


    public Matcher getMatcher(String input);

}