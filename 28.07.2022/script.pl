#!/usr/bin/perl

open(DATA, "<result.txt") or die "Couldn't open file file.txt, $!";


while(<DATA>) {
   if(length($_) > 7){
      $blank = index($_, ' ');
      if(blank > -1){
         $subs = substr $_, 0, $blank;
	print "$subs\n";
	print WDATA "$subs\n"
      }
   }
   open(WDATA,"+>>primeResults.txt") || die "Couldn't open file file.txt, $!";
   
}