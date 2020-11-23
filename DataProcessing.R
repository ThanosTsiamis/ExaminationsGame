Results[is.na(Results)]=0
Results
heatmap(data.matrix(Results),Colv = NA, Rowv = NA,scale="column")
helperrows = rowSums(Results)
helper1rows=seq(1,49,1)
plot(helper,helper1)
helperCols= colSums(Results)
helperCols2=seq(1,14,1)
plot(helperCols2,helperCols)
