//
//  SecondViewController.swift
//  ios
//
//  Created by Alexandre Gherschon on 14/03/2019.
//  Copyright © 2019 Alexandre Gherschon. All rights reserved.
//

import UIKit
import Analytics

class SecondViewController: UIViewController {

    private let eventsHelper: EventsHelper = EventsHelper.init()
    
    override func viewDidAppear(_ animated: Bool) {
        eventsHelper.enterScreen(screen: Screen.dashboard)
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        eventsHelper.exitScreen(screen: Screen.dashboard)
    }

}

