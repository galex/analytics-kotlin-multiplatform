//
//  FirstViewController.swift
//  ios
//
//  Created by Alexandre Gherschon on 14/03/2019.
//  Copyright © 2019 Alexandre Gherschon. All rights reserved.
//

import UIKit
import Analytics

class FirstViewController: UIViewController {
    
    override func viewDidAppear(_ animated: Bool) {
        EventsHelper().enterScreen(screen: Screen.home)
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        EventsHelper().exitScreen(screen: Screen.home)
    }
}

