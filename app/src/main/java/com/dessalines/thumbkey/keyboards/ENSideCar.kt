@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

/**
 * English "Sidecar" 3x6 layout.
 *
 * Grid:
 * Row 0: emoji , o , e , backspace, s, n
 * Row 1: [shift ctrl] , i , t, space, a, d
 * Row 2: num, r, u, enter, h, l
 *
 * - Leftmost column is all control keys (emoji / shift / numeric), coloured grey.
 * - Control column keeps useful swipes, but only in "inward" directions
 *   (no left swipe on col 0, no bottom swipe on bottom row).
 * - Letters + swipes + parentheses as previously designed.
 */

// ---------------------------------------------------------------------
// Custom control keys for Sidecar, using CommonKeys helpers
// ---------------------------------------------------------------------

// Emoji control key: grey, with inward-only utility swipes
private val SIDECAR_EMOJI_KEY_ITEM =
    KeyItemC(
        backgroundColor = SURFACE_VARIANT,
        swipeType = EIGHT_WAY,
        center =
            TOGGLE_EMOJI_MODE_TRUE_KEYC.copy(
                color = MUTED,
            ),
        top = GOTO_SETTINGS_KEYC,          // up: settings
        right = SWITCH_LANGUAGE_KEYC,      // right: switch language
        bottom = SWITCH_IME_KEYC,          // down: switch IME
        topRight = MOVE_KEYBOARD_CYCLE_RIGHT_KEYC,  // up-right: move keyboard
        bottomRight = SWITCH_IME_VOICE_KEYC,        // down-right: voice input
        // no left / topLeft / bottomLeft to avoid off-screen swipes
    )

// Numeric control key: grey, with inward-only text-editing swipes
private val SIDECAR_NUMERIC_KEY_ITEM =
    KeyItemC(
        backgroundColor = SURFACE_VARIANT,
        swipeType = EIGHT_WAY,
        center =
            TOGGLE_NUMERIC_MODE_TRUE_KEYC.copy(
                color = MUTED,
            ),
        top = COPY_KEYC,          // up: copy
        right = PASTE_KEYC,       // right: paste
        topRight = CUT_KEYC,      // up-right: cut
        // you could add more here if you’re okay with slight outward diagonals
        longPress = Undo,         // long-press: undo
    )

val KB_EN_SIDECAR_3X6_MAIN =
    KeyboardC(
        listOf(
            // -----------------------------------------------------------------
            // Row 0: emoji , o , e , backspace, s, n
            // -----------------------------------------------------------------
            listOf(
                // Leftmost: emoji control key (grey, inward swipes only)
                SIDECAR_EMOJI_KEY_ITEM,

                // 'o' key: letter + shift control + 'k' swipe
                KeyItemC(
                    center = KeyC("o", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    // Up swipe = enable shift
                    top =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = ToggleShiftMode(true),
                            swipeReturnAction = ToggleCurrentWordCapitalization(true),
                            color = MUTED,
                        ),
                    // Down swipe = disable shift
                    bottom =
                        KeyC(
                            ToggleShiftMode(false),
                            swipeReturnAction = ToggleCurrentWordCapitalization(false),
                        ),
                    // Right swipe = 'k'
                    right = KeyC("k"),
                ),

                // 'e' key with punctuation + left parenthesis on right
                KeyItemC(
                    center = KeyC("e", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC(".", color = MUTED),
                    top = KeyC(",", color = MUTED),
                    bottom = KeyC("?", color = MUTED),
                    right = KeyC("(", color = MUTED),
                ),

                // Backspace control key (stock behaviour)
                BACKSPACE_KEY_ITEM,

                // 's' key with c/q/- swipes
                KeyItemC(
                    center = KeyC("s", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("c"),
                    bottom = KeyC("q"),
                    top = KeyC("-", color = MUTED),
                ),

                // 'n' key: inward 'b' on down swipe
                KeyItemC(
                    center = KeyC("n", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    bottom = KeyC("b"),
                ),
            ),

            // -----------------------------------------------------------------
            // Row 1: [shift ctrl] , i , t, space, a, d
            // -----------------------------------------------------------------
            listOf(
                // Left column: dedicated shift control (grey)
                KeyItemC(
                    backgroundColor = SURFACE_VARIANT,
                    center =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = ToggleShiftMode(true),
                            swipeReturnAction = ToggleCurrentWordCapitalization(true),
                            color = MUTED,
                        ),
                    bottom =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropDown),
                            action = ToggleShiftMode(false),
                            swipeReturnAction = ToggleCurrentWordCapitalization(false),
                            color = MUTED,
                        ),
                ),

                // 'i' key with ' and ; and 'g' (right)
                KeyItemC(
                    center = KeyC("i", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    top = KeyC("'", color = MUTED),
                    left = KeyC(";", color = MUTED),
                    right = KeyC("g"),
                ),

                // 't' key with p/w/m and 'z' on left
                KeyItemC(
                    center = KeyC("t", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("p"),
                    bottom = KeyC("w"),
                    top = KeyC("m"),
                    left = KeyC("z"),
                ),

                // Spacebar (stock skinny space)
                SPACEBAR_SKINNY_KEY_ITEM,

                // 'a' key with j, !, and right parenthesis on right
                KeyItemC(
                    center = KeyC("a", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("j"),
                    bottom = KeyC("!", color = MUTED),
                    right = KeyC(")", color = MUTED),
                ),

                // 'd' plain
                KeyItemC(
                    center = KeyC("d", size = LARGE),
                ),
            ),

            // -----------------------------------------------------------------
            // Row 2: num, r, u, enter, h, l
            // -----------------------------------------------------------------
            listOf(
                // Left column: numeric control key (grey, inward swipes only)
                SIDECAR_NUMERIC_KEY_ITEM,

                // 'r' key with / and #
                KeyItemC(
                    center = KeyC("r", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("/", color = MUTED),
                    top = KeyC("#", color = MUTED),
                ),

                // 'u' key: inward 'x' on top, ` on right
                KeyItemC(
                    center = KeyC("u", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("`", color = MUTED),
                    top = KeyC("x"),
                ),

                // Enter/return control key
                RETURN_KEY_ITEM,

                // 'h' key with f and v
                KeyItemC(
                    center = KeyC("h", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("f"),
                    top = KeyC("v"),
                ),

                // 'l' key: 'y' inward (left), '@' up
                KeyItemC(
                    center = KeyC("l", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("y"),
                    top = KeyC("@", color = MUTED),
                ),
            ),
        ),
    )

val KB_EN_SIDECAR_3X6_SHIFTED =
    KeyboardC(
        listOf(
            // -----------------------------------------------------------------
            // Row 0: emoji , O , E , backspace, S, N
            // -----------------------------------------------------------------
            listOf(
                SIDECAR_EMOJI_KEY_ITEM,

                // 'O' key: uppercase, 'K' on right
                KeyItemC(
                    center = KeyC("O", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("K"),
                ),

                // 'E' key with punctuation + '(' on right
                KeyItemC(
                    center = KeyC("E", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC(".", color = MUTED),
                    top = KeyC(",", color = MUTED),
                    bottom = KeyC("?", color = MUTED),
                    right = KeyC("(", color = MUTED),
                ),

                BACKSPACE_KEY_ITEM,

                KeyItemC(
                    center = KeyC("S", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("C"),
                    bottom = KeyC("Q"),
                    top = KeyC("_", color = MUTED),
                ),

                KeyItemC(
                    center = KeyC("N", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    bottom = KeyC("B"),
                ),
            ),

            // -----------------------------------------------------------------
            // Row 1: [shift ctrl] , I , T, space, A, D
            // -----------------------------------------------------------------
            listOf(
                // Same shift control behaviour as main; explicitly grey
                KeyItemC(
                    backgroundColor = SURFACE_VARIANT,
                    center =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = ToggleShiftMode(true),
                            swipeReturnAction = ToggleCurrentWordCapitalization(true),
                            color = MUTED,
                        ),
                    bottom =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropDown),
                            action = ToggleShiftMode(false),
                            swipeReturnAction = ToggleCurrentWordCapitalization(false),
                            color = MUTED,
                        ),
                ),

                KeyItemC(
                    center = KeyC("I", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    top = KeyC("'", color = MUTED),
                    left = KeyC(";", color = MUTED),
                    right = KeyC("G"),
                ),

                KeyItemC(
                    center = KeyC("T", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("P"),
                    bottom = KeyC("W"),
                    top = KeyC("M"),
                    left = KeyC("Z"),
                ),

                SPACEBAR_SKINNY_KEY_ITEM,

                // 'A' key with J, !, and ')' on right (mirroring main)
                KeyItemC(
                    center = KeyC("A", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("J"),
                    bottom = KeyC("!", color = MUTED),
                    right = KeyC(")", color = MUTED),
                ),

                KeyItemC(
                    center = KeyC("D", size = LARGE),
                ),
            ),

            // -----------------------------------------------------------------
            // Row 2: num, R, U, enter, H, L
            // -----------------------------------------------------------------
            listOf(
                SIDECAR_NUMERIC_KEY_ITEM,

                KeyItemC(
                    center = KeyC("R", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("/", color = MUTED),
                    top = KeyC("#", color = MUTED),
                ),

                KeyItemC(
                    center = KeyC("U", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("~", color = MUTED),
                    top = KeyC("X"),
                ),

                RETURN_KEY_ITEM,

                KeyItemC(
                    center = KeyC("H", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("F"),
                    top = KeyC("V"),
                ),

                KeyItemC(
                    center = KeyC("L", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("Y"),
                    top = KeyC("@", color = MUTED),
                ),
            ),
        ),
    )

val KB_EN_SIDECAR_3X6: KeyboardDefinition =
    KeyboardDefinition(
        title = "english sidecar 3x6",
        modes =
            KeyboardDefinitionModes(
                main = KB_EN_SIDECAR_3X6_MAIN,
                shifted = KB_EN_SIDECAR_3X6_SHIFTED,
                numeric = HYPER_NUMERIC_KEYBOARD,
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )
