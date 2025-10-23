﻿# Sentinel Messenger © All rights reserved.

*Sentinel Messenger* aims to redefine the standards of secure mobile communication by integrating **state-of-the-art encryption**, **OS-level hardening**, and **decentralized privacy protocols**.  
It is part of the broader **SentinelCybersecurity** initiative — an open-source effort dedicated to building tools that strengthen digital sovereignty and independent cybersecurity infrastructures.

**Advanced encrypted communication platform for privacy, resilience, and digital sovereignty.**  
Derived from [GrapheneMessenger](https://github.com/Andrea-Bruno/GrapheneMessenger), *SentinelMessenger* is a secure messaging system designed for high-risk environments, institutional actors, and individuals who demand uncompromising digital privacy.

### **Sentinel Update Strategy and Security Management**
Sentinel employs a deliberate and conservative update strategy, inspired by stability-focused Linux distributions like **Debian Stable** and the broader principle of **"Conservative Software"** or **"Delayed and Controlled Patching."**

The primary goal is not to be on the latest upstream code in real-time, but to guarantee maximum stability, reliability, and long-term security for our users. We believe that in encrypted messaging, predictability and the absence of regressions are just as important as new features.

#### **The Philosophy: Delayed and Controlled Patching**

Unlike many projects that closely follow every upstream update (the original project, such as GrapheneOS or Signal), Sentinel intentionally applies a slower update cadence. This approach is broken down into two distinct phases:

1.  **Proactive Audit:** When a new upstream update is released (e.g., a new GrapheneOS or Signal-Android release), the Sentinel team does not integrate it immediately. Instead, we analyze the code differences (the `diff`), focusing specifically on changes to security and privacy-critical components.
2.  **Delayed Integration:** Code is integrated into the Sentinel codebase only after a period of "stabilization" and verification. This delay allows us to:
    *   **Identify Bugs and Regressions:** Observe if the update introduces issues in other projects or for a large user base.
    *   **Validate Security Patches:** Ensure that patches for vulnerabilities are effective and do not introduce new flaws or "bug doors."
    *   **Avoid Introducing Malicious Code:** This is the crucial point. A hasty update could theoretically include malicious code that slips through the initial review. Our delay provides an additional window of time for the community and our auditors to scrutinize the changes, drastically reducing this risk.

#### **Critical Exception: Urgent Security Updates**

Our delay policy has one fundamental exception: **critical security vulnerabilities (CVSS High/Critical)**.

If a severe vulnerability is discovered and publicly disclosed in the upstream code, the Sentinel team acts with the highest priority to:
1.  Identify the specific patch that resolves the vulnerability.
2.  Test it intensively.
3.  Rapidly distribute it to Sentinel users as an emergency update.

In these cases, user security takes precedence over the standard delay policy.

#### **Benefits of Our Strategy**

*   **Superior Stability:** The code included in Sentinel has already undergone a "real-world" trial period, resulting in a more stable application with fewer unexpected bugs.
*   **Enhanced Security:** The delayed audit acts as an additional, powerful layer of quality and security control, mitigating the risk of subtle vulnerabilities or backdoors being introduced in updates.
*   **Transparency and Trust:** This process demonstrates our commitment to thorough security, not just fast updates. Users can trust that every change has been scrutinized.

Sentinel's update strategy is a deliberate design choice to prioritize robust and verified security over mere novelty. It is the same philosophy that has made Debian a benchmark for servers and critical systems worldwide. We firmly believe that for a secure messaging application, this is the most responsible approach for our users.

---

## Architecture and Security

![Sentinel](app/src/main/res/drawable-mdpi/welcome.webp)

The reliability of *SentinelMessenger* is built upon a layered architecture that applies advanced cybersecurity principles at every level of operation.  
Each component is designed to minimize attack surfaces, protect data confidentiality, and maintain operational integrity even under hostile conditions.

All communications — including text, audio, and video — are protected by **end-to-end encryption**, ensuring that no intermediary, not even the underlying infrastructure, can access message content.  
Through deep integration with **GrapheneOS**, the application benefits from a fortified environment featuring sandboxing, kernel hardening, and restrictive access controls that extend protection to the system layer.

In addition, *SentinelMessenger* employs **Tor and SOCKS proxy compatibility** to anonymize network activity and eliminate dependencies on centralized services. Notifications are delivered securely via **UnifiedPush**, maintaining full independence from proprietary platforms such as Firebase.

Local data is safeguarded with **encrypted storage**, **secure memory wiping**, and **automatic app locking**, while **advanced backup and multi-device management** ensure continuity without compromising encryption integrity.

This holistic approach allows *SentinelMessenger* to achieve the highest standards of trustworthiness in encrypted communication technology, positioning it as a reference platform for users and organizations that require verifiable security guarantees.

---

# Security Audit Protocol for Sentinel Releases

Sentinel implements a rigorous and systematic audit protocol for every code update prior to final release deployment. This comprehensive security verification process represents a fundamental pillar of our development methodology, ensuring that each release maintains the highest standards of end-to-end encryption and user privacy protection.

The audit protocol encompasses multiple security domains, beginning with core cryptographic verification. We meticulously examine the implementation of encryption algorithms including AES, Curve25519, X3DH, and Double Ratchet protocols. Our analysis verifies proper key length parameters, evaluates cryptographic library integrity, and confirms the presence of essential security properties including forward secrecy and deniability. The entire key management lifecycle undergoes scrutiny from generation through storage and rotation.

Key distribution mechanisms receive particular attention, with thorough assessment of key exchange protocols whether through Diffie-Hellman implementations or QR code methodologies. We validate protection against man-in-the-middle attacks and verify identity confirmation systems such as security fingerprints and contact verification codes. Key transparency audits ensure public key authenticity and prevent manipulation.

Architectural and data flow analysis confirms that no plaintext data transits through servers, with metadata protection safeguarding communication patterns, timing information, and relationship mapping. We verify encryption of backups and multimedia files while assessing client-server isolation through sandboxing and logical separation.

Client-side security evaluation includes memory protection mechanisms, local database encryption, side-channel attack mitigation, and operating system security integration. Server-side assessment ensures zero content visibility, DDoS protection, minimal anonymized logging, and API security hardening.

Update management undergoes digital signature verification, integrity checking, and protection against malicious updates or version rollback attacks. Comprehensive testing includes penetration testing, critical input fuzzing, and simulation of known attack vectors including replay, injection, and protocol downgrade attempts.

Usability and security integration focuses on clear key management interfaces, security change notifications, and protection against user error. Compliance and transparency verification ensures thorough technical documentation, open source auditability, and regulatory adherence.

This multi-layered audit protocol represents Sentinel's unwavering commitment to security excellence, providing users with verified protection rather than assumed security. Each release undergoes this complete assessment cycle, delivering the reliability expected from a privacy-first messaging platform.

---

## Use Cases

- Diplomatic and institutional personnel operating in high-risk environments  
- Journalists, activists, and researchers under surveillance  
- Enterprises adopting zero-trust communication models  
- Cybersecurity professionals and developers seeking verified privacy solutions  

---

## Installation

You can build *SentinelMessenger* from source or install precompiled releases.

### Build from Source

```bash
git clone https://github.com/SentinelCybersecurity/SentinelMessenger.git
cd SentinelMessenger
./gradlew assembleRelease
```

---

## Credits & Licensing

*SentinelMessenger* is a secure communication project developed by **SentinelCybersecurity**, based on the open-source foundation of [GrapheneMessenger](https://github.com/Andrea-Bruno/GrapheneMessenger).  
All source code is released under the **GPLv3 License**, ensuring transparency, auditability, and freedom of use consistent with open cybersecurity principles.

