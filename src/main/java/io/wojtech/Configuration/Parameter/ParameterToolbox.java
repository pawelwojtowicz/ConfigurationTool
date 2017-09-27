package io.wojtech.Configuration.Parameter;

public class ParameterToolbox {
	public static boolean isGenericPath( String path ) {
        int scanState = 0;

        for ( int i = 0; i < path.length() ; ++i) {
            if ( scanState == 0 && '[' == path.charAt(i)) {
                scanState = 1;
            }
            else if ( 1 == scanState && ']' == path.charAt(i))
            {
                return true;
            }
        }
        
        return false;
	}
	
	public static String replaceGenericPath( String genericParameterPath , String templatePathValue) {
		int opening = -1;
		int closing = -1;
		
        for ( int i = 0; i < genericParameterPath.length() ; ++i) {
            if ( opening==-1 && '[' == genericParameterPath.charAt(i)) {
            	opening = i;
            }
            else if ( ']' == genericParameterPath.charAt(i))
            {
                closing = i;
            }
        }
        
        if ( opening >=0 && closing > opening ) {
        	String outputValue = genericParameterPath.substring(0, opening) + templatePathValue;
        	if ( genericParameterPath.length() > closing) {
        		outputValue += genericParameterPath.substring(closing+1);
        	}
        	return  outputValue;
        }	
		
		return "";
	}
}
