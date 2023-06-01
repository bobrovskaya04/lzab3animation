package com.topic3.android.reddit.screens

import androidx.compose.runtime.Composable

@Composable
fun AddScreen(){

}
@@ -23,6 +23,7 @@ import androidx.compose.material.icons.filled.*
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@@ -247,7 +248,54 @@ private fun ScreenNavigationButton(
    */
@Composable
private fun AppDrawerFooter(modifier: Modifier = Modifier) {
    //TODO add your code here
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                bottom = 16.dp,
                end = 16.dp
            )
    ) {
        val colors = MaterialTheme.colors
        val (settingsImage, settingsText, darkModeButton) = createRefs()
        Icon(
            modifier = modifier.constrainAs(settingsImage){
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            },
            imageVector = Icons.Default.Settings,
            contentDescription = stringResource(
                id = R.string.settings
            ),
            tint = colors.primaryVariant
        )
        Text(
            fontSize = 10.sp,
            text = stringResource(R.string.settings),
            style = MaterialTheme.typography.body2,
            color = colors.primaryVariant,
            modifier = modifier
                .padding(start = 16.dp)
                .constrainAs(settingsText) {
                    start.linkTo(settingsImage.end)
                    centerVerticallyTo(settingsImage)
                }

        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_moon),
            contentDescription = stringResource(id = R.string.change_theme),
            modifier = modifier
                .clickable(onClick = { changeTheme() })
                .constrainAs(darkModeButton){
                    end.linkTo(parent.end)
                    bottom.linkTo(settingsImage.bottom)
                },
            tint = colors.primaryVariant
        )

    }
}

private fun changeTheme() {